npm init<br>
npm install webpack --save-dev <br>
touch webpack.config.js<br>
```
// webpack.config.js
module.exports = {
 entry: ‘./src/client.js’,
 output: {
   path: __dirname + ‘/public’,
   fiename: ‘client.js’,
 },
};
```
npm install -g webpack-dev-server<br>
npm run start<br>
 [参考](https://qiita.com/ftyabu/items/240280617a69777a2fd4)
