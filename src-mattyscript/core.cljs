(ns core)

(literal
  "import preact from \"preact\";
  const {h} = preact;")
(import "./util" [inc])
(import "./state" [Atom UnmountingComponent])

(def click-count (Atom. 0))
(def seconds-elapsed (Atom. 0))

(defcomponent counting-component []
  [:div {}
   "The atom " [:code {} "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me!"
            :onClick #(click-count.swap inc)}]])

(defcomponent timer-component []
  [:div {} "Seconds Elapsed: " @seconds-elapsed])

(window.setInterval #(seconds-elapsed.swap inc) 1000)

(defcomponent app []
  [:div {}
   [:h3 {} "Welcome to my little app"]
   (invoke-component counting-component "counter")
   (invoke-component timer-component "timer")])

(defn main []
  (let [container (document.getElementById "content")]
    (preact.render [:App {:key "app"}] container container.lastElementChild)))

;start the app
(main)
