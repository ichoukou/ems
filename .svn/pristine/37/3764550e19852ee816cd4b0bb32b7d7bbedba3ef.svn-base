package com.channelsoft.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuxing on 2016/12/23.
 */
@Controller
@RequestMapping("/storageEntry")
public class StorageEntryController {

    private static Logger logger=Logger.getLogger(StorageEntryController.class);

    @RequestMapping("/seList")
    public String gotoStorageEntryList(){
        logger.debug("seList已经跳转");
        return "storageEntry/storageEntryList";
    }
}
