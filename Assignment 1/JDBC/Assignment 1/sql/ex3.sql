-- For exercise 3

    -- Degeneracy presssure
        create or replace function q3_section() returns trigger as $q3_section$
        begin 
            if (new.time_slot_id, new.semester, new.year, new.building, new.room_number) in (
                select time_slot_id, semester, year, building, room_number from section
            ) then raise exception 'Degeneracy pressure.'; rollback; 
            end if;
            return new; 
        end; 
        $q3_section$ language plpgsql;

        create or replace trigger q3_section before insert or update on section 
        for each row execute function q3_section();

    -- Spatial delocalisation
        create or replace function q3_teaches() returns trigger as $q3_teaches$
        begin 
            if not exists (
                select time_slot_id, semester, year from section 
                    where section.course_id = new.course_id and 
                    section.sec_id = new.sec_id and 
                    section.semester = new.semester and 
                    section.year = new.year 
                except 
                select time_slot_id, semester, year from section 
                    where (new.id, section.course_id, section.sec_id, section.semester, section.year) in 
                    (select * from teaches where "id" = new.id)
            ) then raise exception 'Spatial delocalisation.'; rollback; 
            end if;
            return new; 
        end; 
        $q3_teaches$ language plpgsql;

        create or replace trigger q3_teaches before insert or update on teaches 
        for each row execute function q3_teaches();
    
    -- Bad time slot.
        create or replace function q3_section_time() returns trigger as $q3_section_time$
        begin 
            if new != old and 
            (new.semester, new.year, new.time_slot_id) in (
                select semester, year, time_slot_id from section 
                    where course_id in (
                        select course_id from teaches 
                            where id in (
                                select id from teaches where course_id = new.course_id
                            )
                    )
            ) 
            then raise exception 'Bad time slot.'; rollback; end if;
            return new; 
        end; 
        $q3_section_time$ language plpgsql;
        
        create or replace trigger q3_section_time before update on section 
        for each row execute function q3_section_time();

