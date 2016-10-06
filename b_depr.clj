;;  TODO: replace recursive calls with recur

(defn popu-list
  "return nested list representing recursively file contents of specified directory, f"
  [f]
  (let [cont (fs/list-dir f)]
   (cons
     (fs/name f)
     (cons
       (map (partial fs/name) 
            (filter #(not (fs/directory? %)) cont))
       (map popu-list (filter fs/directory? cont))))))

(defn pprint-ftree
    "pretty print file tree"
    [file-tree]
    (let [item-count (count (flatten file-tree))] ;; need to filter empty lists
        (pprint-ftree* file-tree [] true)
        (println "Total items: " item-count)

(defn pprint-ftree*
  "helper recursive function for pprint-ftree
  ***
  a -> folder-name
  depth-count -> vector used to space appropriately and draw lines"
  [a depth-count new-seq]
  (cond
    (and (empty? (first a))
         (zero? (reduce + depth-count))) nil ;; nothing left
    (and (not? (empty? (first a)))  ;; new seq
         (new-seq)) (do (println (draw-space-lines depth-count) (first a))
                        (pprint-ftree* (rest a) 
                                       (conj depth-count (count (rest a)) ;; TODO dec here
                                       (and (seq? (second a)) (not (empty? (second a)))))))
    (and (not? (empty? (first a))) ;; not new seq 
         (not new-seq)) (do (println (draw-space-lines depth-count) (first a))
                            (pprint-ftree* (rest a) 
                                           (if (= 0 (last depth-count)) 
                                             (drop-last depth-count)
                                             (conj (drop-last depth-count) (dec (last depth-count))))
                                           (and (seq? (second a)(not (empty? (second a)))))))))

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
  p '(("b" "c") "d") [2] true => "\u251cb"        ;; dec error
    p '(("c") "d") [2 1] false => "\u2502\u2514c"
      p '("d") [2 0]  

)


(defn draw-space-lines
  "render lines of pprint-ftree(*)"
  [depth-count]
  ;; TODO: extend to variable spacing, lineless rendering
  (let [north-east "\u2514"
        north-south "\u2502"
        north-east-south "\u251c"]
  (cond
    (empty? depth-count) ""
    (and (= 1 (first depth-count))
         (not (integer? (second depth-count)))) (str north-east (draw-space-lines (rest depth-count)))
    (and (< 1 (first depth-count))
         (not (integer? (second depth-count)))) (str north-east-south (draw-space-lines (rest depth-count)))
    (and (< 0 (first depth-count))
         (integer? (second depth-count))) (str north-south (draw-space-lines (rest depth-count)))
    (zero? (first depth-count)) (str " " (draw-space-lines (rest depth-count))))))

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
    dsl [] => ""
  )
