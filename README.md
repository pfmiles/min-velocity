# 目标：
以velocity 1.7为基础, 裁剪出适合用作代码生成的模板引擎

# 裁剪：
* 没有event机制
* 没有macro
* 没有stop
* 没有evaluate

# 改动：
* requires jdk1.5+
* 默认情况下，日志输出到标准输出/标准错误流而非文件
* 默认采用classpath模板加载器而非文件系统模板加载器
* velocity.log removed
* default I/O encoding changed to UTF-8(from iso-8859-1)
* 对于#set指令，默认允许设置null值
* parser pool内parser实例默认数量为1(原本为20)

# 改进：
* TODO