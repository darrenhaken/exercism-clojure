(ns binary-search)

(defn middle-index [items]
  (quot (count items) 2))

(defn item-not-found? [middle-index items]
  (or (= middle-index (count items)) (zero? middle-index)))

(defn throw-not-found [element]
  (throw (Exception. (format "%s not found in list" element))))

(defn search-for [target items]
  (let [middle-index (middle-index items)
        middle-item (nth items middle-index)]
    (cond
      (= target middle-item) middle-index
      (item-not-found? middle-index items) (throw-not-found target)
      (< middle-item target) (+ middle-index (search-for target (drop middle-index items)))
      (> middle-item target) (search-for target (take middle-index items)))))
