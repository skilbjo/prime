(defproject prime "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :uberjar-name "prime.jar"
  :main ^:skip-aot prime.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
