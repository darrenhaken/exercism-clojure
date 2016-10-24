(ns gigasecond
  (require [clj-time.core :as t])
  (require [clj-time.format :as f])
  (require [clojure.math.numeric-tower :as math]))

(def ^:private gigaseconds
  (math/expt 10 9))

(defn- date-string [year month day]
  (str year "-" month "-" day))

(defn- parse-date [year month day]
  (f/parse
    (f/formatters :year-month-day)
    (date-string year month day)))

(defn- gigadate [year month day]
  (t/plus (parse-date year month day) (t/seconds gigaseconds)))

(defn- date->vector [date]
  [(t/year date) (t/month date) (t/day date)])

(defn from [year month day]
  (-> (gigadate year month day)
      date->vector))
