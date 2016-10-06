(defproject tree "0.1.0-SNAPSHOT"
  :description "UNIX tree utility implemented functionally"
  :url "https://github.com/ds2643/treecl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [me.raynes/fs "1.4.6"]]
  :main ^:skip-aot tree.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
