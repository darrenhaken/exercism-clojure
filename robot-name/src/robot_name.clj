(ns robot-name)

(def ^:private alphabet
  (map char (range (int \A) (inc (int \Z)))))

(defn- generate-id []
  (format "%s%s%03d"
          (rand-nth alphabet)
          (rand-nth alphabet)
          (rand-int 1000)))

(defrecord Robot [name])

(defn robot []
  (Robot. (atom (generate-id))))

(defn robot-name [robot]
  @(:name robot))

(defn reset-name [robot]
  (reset! (:name robot) (generate-id)))
