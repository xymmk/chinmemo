npm init<br>
npm i -D AssemblyScript/assemblyscript<br>
npx asinit .<br>
npm run asbuild<br>
touch index.html
```
//index.html

<h1>It works!</h1>
<script>
  async function loadWasm(url, opt = {}) {
    const wasmRaw = await fetch(url).then(res => res.arrayBuffer());
    const wasmObj = await WebAssembly.instantiate(wasmRaw, opt);
    return wasmObj;
  }

  loadWasm('build/optimized.wasm', {}).then(wasm => {
    console.log(wasm.instance.exports.add(42, 24));
  });
</script>A
```
ブラウザー確認<br>
```
# Python2の場合
$ python -m SimpleHTTPServer 8080

# Python3の場合
$ python3 -m http.server 8080

# Rubyの場合
$ ruby -run -e httpd . -p 8080

# node.jsの場合
$ npx http-server -p 8080
```

node.jsを使う場合(index.html無しでも大丈夫)<br>
```
const wasm = require('./index.js');
```
