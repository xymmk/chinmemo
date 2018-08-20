# 1NF 2NF 3NF
```
1NF:每个属性都是不可分的基本数据项
id	phoneNum			Name			id		phoneNum				Name
1	1234566,7987798			aaa              →	1		1234566					aaa
2	789423,3423,423432		bbb			2		7987798					aaa
								3		789423					bbb
								4		3423					bbb
								5		423432					bbb

2NF:每个非主属性都完全函数依赖于主键
address					name		height			postalCode			
Tokyo 2-1-1 1007			aaa		190cm			135-0001
Kyoto 3-1-1 1007			bbb		100cm			145-0001

(address,name) → height
(address)      → postalCode (存在局部依赖关系,不符合2NF)

3NF:既不存在传递依赖关系，也不存在局部依赖关系
id		Name		deptNo		deptName		id	Name	|			deptNo			deptName
1		aaa		1		Japan		→	1	aaa	|			1			Japan
2		bbb		2		China			2	bbb	|			2			China

id → Name
id → deptNo → deptName (存在传递依赖关系,不符合3NF)

```
