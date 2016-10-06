~/loom [ tree                                                                   master * ] 4:32 AM
# ANNOTATED TO DESCRIBE LOADING
.						;;  "."
├── CHANGELOG.md				;; ("." "CHANGELOG.md")
├── doc						;; ("." "CHANGELOG.md" ("doc")) 
│   ├── loom_logo.png				;; ("." "CHANGELOG.md" ("doc" "loom_logo.png"))
│   ├── loom_logo.svg				;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg"))
│   └── ns-dep-graph.png			;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png"))
├── project.clj					;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj")
├── README.md					;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md")
├── scripts					;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md" ("scripts" ))
│   └── test					;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md" ("scripts" "test"))
├── src						;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md" ("scripts" "test") ("src"))
│   └── loom					;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md" ("scripts" "test") ("src" "alg.cljc"))
│       ├── alg.cljc				;; ("." "CHANGELOG.md" ("doc" "loom_logo.png" "loom_logo.svg" "ns-dep-graph.png") "project.clj" "README.md" ("scripts" "test") ("src" "alg.cljc" "alg_generic.clj"))
│       ├── alg_generic.cljc			;;																			"..."
│       ├── attr.cljc				;;
│       ├── compliance_tester.clj		;;
│       ├── dataflow.clj			;;
│       ├── derived.clj				;;
│       ├── flow.cljc				;;
│       ├── gen.cljc				;;
│       ├── graph.cljc				;;
│       ├── io.cljc				;;
│       └── label.cljc				;;
├── target					;;
│   ├── classes					;;
│   │   └── META-INF				;;
│   │       └── maven				;;
│   │           └── aysylu			;;
│   │               └── loom			;;
│   │                   └── pom.properties	;;
│   └── stale
│       └── leiningen.core.classpath.extract-native-dependencies
└── test
    └── loom
        └── test
            ├── alg_generic.clj			;; 
            ├── attr.clj			;; 
            ├── derived.clj			;; 
            ├── flow.clj			;; 
            ├── graph.clj			;; 
            └── label.clj			;; 

14 directories, 26 files


****************************************************************
****************************************************************
****************************************************************

0. load-traversal
	a. spice with java.lang.system

(defn load*
  [x]
  (cond
  (folder? x) (cons
		(str x)
		(load (contents x)))
  :else (str x)
))

(defn load
  [x]
  (cond
    (= x nil) '())
    ;else (cons 
            (load* x)
            (load (rest x))))

(defn contents
  [x]
  "wrapper for file content grabber"
  ()
)

+----------------+
|java.lang.System|
+----------------+


1. print-traversal
	> dfs deriv


(def directory (clojure.java.io/file "."))
(def files (file-seq directory))
(take 10 files)

(seq (.list (clojure.java.io/file ".")))


	
