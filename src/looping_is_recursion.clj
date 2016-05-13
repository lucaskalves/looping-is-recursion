(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc b e]
                 (cond
                   (= e 1) acc
                   :else (recur (* acc b) b (dec e))))]
    (if (zero? exp)
      1
      (helper base base exp))))

(defn last-element [a-seq]
  (if (empty? (rest a-seq))
    (first a-seq)
    (recur (rest a-seq))))

(defn seq= [seq1 seq2]
  (cond 
    (and (empty? seq1) (empty? seq2)) true
    (or (empty? seq1) (empty? seq2)) false
    (= (first seq1) (first seq2)) (recur (rest seq1) (rest seq2))
    :else false))

(defn find-first-index [pred a-seq]
  (loop [i 0
         p pred
         s a-seq]
    (cond
      (empty? s) nil
      (p (first s)) i
      :else (recur (inc i) p (rest s)))))

(defn avg [a-seq]
  (loop [acc 0
         total 0
         s a-seq]
    (cond
      (and (pos? total) (empty? s)) (/ acc total)
      (and (zero? total) (empty? s)) nil
      :else (recur (+ acc (first s)) (inc total) (rest s)))))

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

