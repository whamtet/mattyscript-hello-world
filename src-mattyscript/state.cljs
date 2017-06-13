(ns state)

(import "./util" [assert assoc dissoc])
(literal
  "import preact from \"preact\";
  const { h, Component } = preact;")

;;remove disabled component

(class ^:export UnmountingComponent Component
       (fn constructor [name]
         (super)
         (assert name "null name in UnmountingComponent constructor")
         (set! this.name name))
       (fn componentDidUnmount []
         (set! this.unmounted true)))

(class ^:export Atom
       (fn constructor [value]
         (set! this.state value)
         (set! this.components {}))
       (fn deref [component]
         (assert component.name "no name for component")
         (assoc this.components component.name component)
         this.state)
       (fn reset [new-value]
         (set! this.state new-value)
         (let [
                old-components this.components
                ]
           (set! this.components {})
           (doseq [k (Object.keys old-components)
                   :let [component (get old-components k)]
                   :when (not component.unmounted)]
             (assoc this.components k component)
             (component.setState component.state))))
       (fn update []
         (this.reset this.state))
       (fn swap [f & args]
         (this.reset (apply f this.state args))))
