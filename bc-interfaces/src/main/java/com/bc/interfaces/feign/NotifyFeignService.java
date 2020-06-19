package com.bc.interfaces.feign;

import com.bc.interfaces.model.NotifyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="bc-notify")
public interface NotifyFeignService {

    /**
     * 调用适配器服务发送回调给下游
     * @param notifyModel
     * @return
     */
    @RequestMapping(value = "manual/manualNotify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String notify(@RequestBody NotifyModel notifyModel);
}
