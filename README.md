# Mattyscript Hello World

A simple demo of [Mattyscript](https://github.com/whamtet/mattyscript) used in conjunction with Reagent.

## Building

Clone [Mattyscript](https://github.com/whamtet/mattyscript) into this directory and load the `mattyscript.watch` namespace.  Mattyscript emits `.jsx` files into src-preact that we compile into the final output.

```bash
cd src-preact
npm i
webpack
```

Finally start a server that can run `index.html`

```bash
python -m SimpleHTTPServer
```
