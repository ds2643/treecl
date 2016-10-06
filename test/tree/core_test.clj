(ns tree.core-test
  (:require [clojure.test :refer :all]
            [tree.core :refer :all]))

(comment

  ;; environment dependant
  ;; use property based tests
(deftest popu-list-test
  (testing ""
    (are [expected f]
         (= expected (popu-list f))
         _ _
         _ _)))

(deftest draw-space-lines-test
  (testing ""
    (are [expected depth-count]
         (= expected (draw-space-lines depth-count))
         _ _
         _ _)))

(deftest pprint-ftree*-test
  (testing ""
    (are [expected a depth-count new-seq]
         (= expected (pprint-ftree* a depth-count new-seq))
         _ _ _ _
         _ _ _ _)))

(deftest pprint-ftree-test
  (testing "pretty print function for file trees represented as lists"
    (are [expected _param1]
         (= expected (pprint-ftree re))
         "a" '("a")
         _  '("a" "b")
         "" '()
         _ '("a" ("b"))
         _ '("a" ("b" "c") "d")
         )))


(comment
         ;; TODO: repl tests
  p '("a") [] true => "a"
    p '() [0] => nil
      p '("a" "b") [] true => "a"
  p '("b") [1] false  => "\u2514b"
    p '() [0] false => ""
  p '("a" ("b")) [] true => "a"
    p '(("b")) [1] true => "\u2514b"
      p '(()) [0] false => ""
  p '("a" ("b" "c") "d") [] true => "a"
    p '(("b" "c") "d") [2] true => "\u251cb"  ;; dec error
      p '(("c") "d") [2 1] false => "\u2502\u2514c"
        p '("d") [2 0] => "| d" ;; incorrect
  )

(comment
         ;; repl tests
  ;; TODO: add to tests/
  dsl [] => ""
    dsl [0] => " "
      dsl [] => ""
  dsl [0 0] => " "
    dsl [0] => " "
      dsl [] => ""
  dsl [1] => "NE"
    dsl [] => ""
  dsl [0 1] => " "
    dsl [1] => "NE"
      dsl [] => ""
  dsl [0 2] => " "
    dsl [2] => "NES"
      dsl [] => ""
  dsl [1 0] => "NS"
    dsl [0] => " "
      dsl [] => ""
  dsl [2 0] => "NS"
    dsl [0] => " "
      dsl [] => "")
