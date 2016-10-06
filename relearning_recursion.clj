(defn pprint-ftree-1
  "pretty print file tree represented by recursive list structure"
  [xs dc]
  (let [current (first xs)]
  (cond
     (nil? current) nil 
     (and (seq? current) 
          (not (empty? current))) (do
                                      (pprint-ftree-1 current
                                                      (conj 
                                                        (conj
                                                          (into [] (drop-last dc))
                                                          (dec (last dc))) 
                                                        (count (rest current)))
                                                      )
                                      (pprint-ftree-1 (rest xs)
                                                      (if (not (empty? dc))
                                                          (conj (into [] (drop-last dc))
                                                            (dec (last dc)))
                                                        )))
    :else (do
            (println (draw-space-lines dc) current
                     ;; DEBUG
                     "      :: " dc
                     )
            (pprint-ftree-1 (rest xs)
                            (if (empty? dc)
                              (conj dc (count (rest xs)))
                              (if (zero? (last dc)) ;; unnecessary
                                (into [] (drop-last dc))      ;; unnecessary 
                                (conj (into [] (drop-last dc)) (dec (last dc)))
                                
            )))))))


