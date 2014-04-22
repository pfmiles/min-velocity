# 裁剪：
* 没有event机制
* 没有macro
* 没有stop
* 没有evaluate

# 改动：
* 默认情况下，日志输出到标准输出/标准错误流而非文件
* 默认采用classpath模板加载器而非文件系统模板加载器
* velocity.log removed
* default I/O encoding changed to UTF-8(from iso-8859-1)
* 对于#set指令，默认允许设置null值
* resourceLoader defaults to 'classpath'

# 改进：
* TODO