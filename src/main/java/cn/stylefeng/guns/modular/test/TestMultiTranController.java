package cn.stylefeng.guns.modular.test;

import cn.stylefeng.guns.modular.test.service.TranTestService;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试多数据源
 *
 * @author stylefeng
 * @since 2018/7/20 23:39
 */
@RestController
@ApiResource(name = "测试多数据源")
public class TestMultiTranController {

    @Resource
    private TranTestService testMultiDbService;

    @GetResource(name = "测试多数据源成功", path = "/tran/multi/success")
    public ResponseData<Object> testSuccess() {
        testMultiDbService.beginTest();
        return new SuccessResponseData<>();
    }

    @GetResource(name = "测试多数据源失败", path = "/tran/multi/fail")
    public ResponseData<Object> testFail() {
        testMultiDbService.beginTestFail();
        return new SuccessResponseData<>();
    }

}

