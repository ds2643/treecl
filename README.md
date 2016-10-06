# tree

FIXME: description

## Installation

- Download from https://github.com/ds2643/treecl.
- Use Leiningen (http://leiningen.org/) to compile:

    $ lein jar # creates package with code OR

    $ lein uberjar # creates package with code and all dependancies included

- Run:
    
   $ java -cp tree-0.1.0-standalone.jar 

- Note: This set of instructions is not yet complete

## Usage

In an arbitrary directory, simply call the program jar, followed by a file. 
The contents of that files are displayed recursively in the terminal.

    $ java -jar tree-0.1.0-standalone.jar

## Examples

$ java -cp tree-0.1.0-standalone.jar "."
tree 
├.lein-failures 
│├README 
│├.lein-repl-history 
│├CHANGELOG 
│├.README.md 
│├.hgignore 
│├project 
│├LICENSE 
│└.gitignore 
├test 
│├clojure.lang.LazySeq@1 
│└tree 
│ └core_test 
...

### Bugs

$ -Tests incomplete
-No option for toggling display of dot files

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
