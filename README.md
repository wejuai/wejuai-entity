# wejuai 为聚爱
跨模块使用的数据实体

### 结构
- entity：不同类型的实体
  - mongo
  - mysql
  - session：只在不同项目间session中流转的数据实体，不会存储
- exception：通用异常
- util：实体中使用的工具

### 配置
`build.gradele`中配置仓库地址，以及拥有权限的github key

### 使用
1. gradle构建成功
2. 运行gradle task中的`publishing/publishToMavenLocal`安装到本地
3. 运行`publishing/publish`发布到对应仓库的packages中