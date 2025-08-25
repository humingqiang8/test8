import time
import functools
import logging
from typing import Callable, Optional

def timing_decorator(
    func: Optional[Callable] = None, 
    *, 
    logger: Optional[logging.Logger] = None,
    log_level: int = logging.INFO,
    message_format: str = "Function '{name}' executed in {time:.4f} seconds"
):
    """
    装饰器：记录函数的执行时间
    
    参数:
        func: 被装饰的函数
        logger: 用于记录日志的logger对象，如果为None则使用print
        log_level: 日志级别
        message_format: 日志消息格式，可用的占位符有 {name} 和 {time}
    """
    def decorator_timing(func: Callable):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            start_time = time.perf_counter()
            result = func(*args, **kwargs)
            end_time = time.perf_counter()
            execution_time = end_time - start_time
            
            # 格式化消息
            message = message_format.format(name=func.__name__, time=execution_time)
            
            # 记录日志
            if logger:
                logger.log(log_level, message)
            else:
                print(message)
                
            return result
        return wrapper
    
    # 支持 @timing_decorator 和 @timing_decorator() 两种语法
    if func is None:
        return decorator_timing
    else:
        return decorator_timing(func)

# 配置一个基本的日志记录器
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

# 创建一个自定义logger用于演示
custom_logger = logging.getLogger("timing_logger")
# 添加处理器并设置级别
handler = logging.StreamHandler()
handler.setFormatter(logging.Formatter('%(name)s - %(levelname)s - %(message)s'))
custom_logger.addHandler(handler)
custom_logger.setLevel(logging.DEBUG)
# 防止日志传播到根logger
custom_logger.propagate = False

# 示例1: 基本用法
@timing_decorator
def example_function_one(n):
    """示例函数1：计算从1到n的和"""
    total = 0
    for i in range(n):
        total += i
    return total

# 示例2: 使用自定义logger
@timing_decorator(logger=custom_logger, log_level=logging.DEBUG)
def example_function_two(n):
    """示例函数2：计算从1到n的平方和"""
    total = 0
    for i in range(n):
        total += i**2
    return total

# 示例3: 使用自定义消息格式
@timing_decorator(message_format=">>> {name} 执行耗时 {time:.6f} 秒 <<<")
def example_function_three(sleep_time):
    """示例函数3：休眠指定时间"""
    time.sleep(sleep_time)
    return "休眠完成"

if __name__ == "__main__":
    print("示例1: 基本用法")
    result1 = example_function_one(1000000)
    print(f"计算结果: {result1}\n")
    
    print("示例2: 使用自定义logger")
    result2 = example_function_two(1000000)
    print(f"计算结果: {result2}\n")
    
    print("示例3: 使用自定义消息格式")
    result3 = example_function_three(0.5)
    print(f"函数返回: {result3}\n")