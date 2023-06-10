## Directories:
- .java files in `src`
- .jar files in `lib`
- .class files in `bin`
- .tex, .pdf, .png files in `report`
- .json files in `.vscode`
- .sql files in `sql`

## Instructions:
- Install the recommended plugins on VScode and click on "Run|Debug" above the main method in App.java
- Ensure that the root directory of VScode window is CS21BTECH11001_ABHAY
- To reproduce the output, redirect `input.txt` into the command. 
  - macOS(my machine, anyway): `/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-18.jdk/Contents/Home/bin/java @/var/folders/2g/x5rm_g0n3d78hzs6_cgf5hbr0000gn/T/cp_90777hypc3mhsxkrndtvj1jft.argfile App < input.txt`
  - Linux: 

## Overview
- Interactive CLI, choice-based multiplexing
- Each .java file contains code for execution of one exercise, except for App.java which contains code for connecting to the database, some DDL and the CLI code.
-  Naturally, all of this only works on my machine due to database authentication specificity. Portability can be implemented by changes to the source code within `DB.connect()`.
-  Due to the verbose nature of java library nomenclature, documentation is redundant.