(ns tree.core-test
  (:require [clojure.test :refer :all]
            [tree.core :refer :all]))

(deftest popu-list-test
  (testing "popu-list function"
    (is (seq? (popu-list ".")))
    (is (= (count (flatten (popu-list "."))) (count (file-seq (clojure.java.io/file ".")))))))

(deftest render-lines-test
  (testing "render lines function"
    (are [expected input]
         (= expected (render-lines input))
         "" []
         nil [0]
         "└" [1]
         "├" [2]
         "├" [99]
         " └" [1 1]
         "│└" [2 1]
         "│├" [2 2]
         "│ ├" [2 1 2])))

(deftest pprint-ftree-1-test
  (testing "pretty print function"
    (are [expected lol d n]
         (= expected (pprint-ftree-1 lol d n))
         "a" '("a") [] true
         "1 
         └2"  '("a" "b") [] true
         "" '() [] [] true
         "a 
         └b" '("a" ("b")) [] true
         "a 
         └b 
          └c" '("a" ("b" "c") "d")
         "a 
         ├b 
         │└c 
         └123" '("a" ("b" "c") 123) [] true
        "a 
        ├b 
         │└c 
         └1 
          ├2 
          ├3 
          │└4 
          ├5 
          │└6 
          └8 
           ├8 
           ├8 
           └8" '("a" ("b" "c") (1 2 (3 4) (5 6) (8 8 8 8))) [] true)))
