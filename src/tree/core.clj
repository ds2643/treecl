(ns tree.core
  (:gen-class)
  (:require [me.raynes.fs :as fs]))

(defn popu-list
  "creates nested list tree structure of the directory supplied by argument"
  [f]
  (let [cont (fs/list-dir f)]
    (cons
      (fs/name f)
      (cons
        (map (partial fs/name)
             (filter #(not (fs/directory? %)) cont))
        (map popu-list (filter fs/directory? cont))))))

(defn render-lines
  [d]
  (let [north-east "\u2514"  space " "
        north-south "\u2502" north-east-south "\u251c"]
    (cond
      (empty? d) ""
      (and (= 1 (first d)) (not (integer? (second d))))
        (str north-east (render-lines (rest d)))
      (and (< 1 (first d)) (not (integer? (second d))))
        (str north-east-south (render-lines (rest d)))
      (and (< 1 (first d)) (integer? (second d)))
        (str north-south (render-lines (rest d)))
      (and (= 1 (first d)) (integer? (second d)))
        (str space (render-lines (rest d))))))

(defn pprint-ftree-1
  "pretty print file tree represented by recursive list structure"
  [xs dc p]
  (let [current (first xs)]
    (cond
      (nil? current) nil
      (and (seq? current) (not (empty? current)))
        (do
          (pprint-ftree-1 current dc true)
          (pprint-ftree-1 (rest xs)
                          (if (not (empty? dc))
                            (conj (into [] (drop-last dc))
                                  (dec (last dc))))
                          false))
      :else 
        (do
          (print (render-lines dc) (str "\b" current) "\n")
          (pprint-ftree-1 (rest xs)
                          (if p
                            (conj dc (count (rest xs)))
                            (if (= 1 (last dc))
                              (into [] (drop-last dc))
                              (conj (into [] (drop-last dc)) (dec (last dc)))))
                          false)))))

(defn pprint-ftree
  "pretty print file tree"
  [file-tree]
  (let [item-count (count (flatten file-tree))] ;; need to filter empty lists
    (pprint-ftree-1 file-tree [] true)
    (println "Total items: " item-count)))

(defn -main
  [& args]
  (pprint-ftree (popu-list ".")))
