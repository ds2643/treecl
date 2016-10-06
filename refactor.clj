(defn pprint-ftree-1
  "pretty print file tree represented by recursive list structure"
  [xs dc p]
  (let [current (first xs)]
  (cond
     (nil? current) nil 
     (and (seq? current) 
          (not (empty? current))) (do
                                      (pprint-ftree-1 current dc true)
                                      (pprint-ftree-1 (rest xs)
                                                      (if (not (empty? dc))
                                                          (conj (into [] (drop-last dc))
                                                            (dec (last dc))) 
                                                        ) false))
    :else (do
            (println (draw-space-lines dc) current)
            (pprint-ftree-1 (rest xs)
                            (if p
                              (conj dc (count (rest xs)))
                              (if (= 1 (last dc))
                                (into [] (drop-last dc))   
                                (conj (into [] (drop-last dc)) (dec (last dc)))))
                             false )))))


