# treecl

A functional implementation of the classic UNIX utility, tree, in Clojure.

This project is motivated by the challenge of reimagining tools developers use daily with modern tools. While use of this tool is somewhat impractical from a development standpoint (the Java Virtual Machine that Clojure runs on boots up to slowly for the purpose of a command-line tool), the exercise of coding tree recusively is still worthwhile.

In short, treecl prettyprints the contents of the current directory recursively, with depth illustrated with whitespace and connections between files rendered with unicode lines. The codebase is fairly straightforward: the Java interop is leveraged to traverse the file tree recursively, with depth passed as a parameter to the recursive function. A unicode map translates the depth vector information into the appropriate unicode.

## Installation

- Download from https://github.com/ds2643/treecl.
- Use Leiningen (http://leiningen.org/) to compile:
    $ lein uberjar # creates package with code and all dependancies included

- Run:
   $ java -cp treecl-0.1.0-standalone.jar

## Examples

```
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
```

### Future

1. Tests incomplete
2. Add option for toggling display of dot files
3. Improve command line interface

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
