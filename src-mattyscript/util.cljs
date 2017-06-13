(ns util)

(defn ^:export assert [b msg]
  (if-not b (throw (Error. msg))))

(defn ^:export assoc [m k v]
  (if m
    (do
      (literal "m[k] = v;")
      m)
    {k v}))

(defn ^:export dissoc [m k]
  (literal "delete m[k]")
  m)

(defn ^:export inc [x]
  (+ x 1))
