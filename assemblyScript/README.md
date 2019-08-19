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
�֥饦���`�_�J<br>
```
# Python2�Έ���
$ python -m SimpleHTTPServer 8080

# Python3�Έ���
$ python3 -m http.server 8080

# Ruby�Έ���
$ ruby -run -e httpd . -p 8080

# node.js�Έ���
$ npx http-server -p 8080
```

node.js��ʹ������(index.html�o���Ǥ���ɷ�)<br>
```
const wasm = require('./index.js');
```