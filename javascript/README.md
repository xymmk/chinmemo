# let var const
	➀　let 			(块作用域)
	➁　var 			(函数作用域，全局,使用var的花没有块作用域的概念)
	➂　const 		(块作用域常量)
## example
### ➀ let
```
//*******************块作用域*************************

for(let i = 0; i < 10 ;i++){
	console.log(i);//0,1,2,3,4.....10
}
	console.log(i);//undefined

//********************函数作用域**********************

function(){
	let a = 10;
	console.log(a);//10
}
	console.log(a);//undefined

```
### ➁ var
```
//*******************块作用域*************************
for(var i = 0; i < 10 ;i++){
	console.log(i);//0,1,2,3,4.....10
}
	console.log(i);//0,1,2,3,4.....10

//********************函数作用域(与let一样)*************
function(){
	let a = 10;
	console.log(a);//10
}
	console.log(a);//undefined
```

### ➂ const
```
与let一致，但是值不可以修改
```

# 变量提升
```
//在执行任何代码段之前，将函数声明放入内存中的优点之一是，这允许你可以在你的代码中使用一个函数，在声明该函数之前

show("aaa")
function show(str){
	console.log(str);//aaa 先调用再声明
}

console.log(x);//x is undefined 只是提升声明，不提升初始化
var x = 10;
```
