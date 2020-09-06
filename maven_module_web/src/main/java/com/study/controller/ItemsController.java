package com.study.controller;

import com.study.domain.Items;
import com.study.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    项目模块化后启动的三种方式:
        - 直接启动父工程
        - 若要单独启动maven_module_web模块(它导入了service和dao的依赖也是个完整的项目),则需要使用maven的install命令将
          所有web需要的模块安装到本地仓库(说人话就是直接安装父工程到本地仓库),这样它才有service模块和dao模块支持,因为模块
          化之后service模块和dao模块都算是jar包,导入依赖时maven发现本地仓库和中央仓库都没有,就无法继续完成项目启动
        - 本地tomcat启动(跟正常使用一样)
 */
@Controller
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("findItemById")
    public String findItemById(Integer id,Model model){
        // 查询
        Items item = itemsService.findById(id);
        // 保存到request域
        model.addAttribute("item",item);
        // 返回itemDetail视图
        return "itemDetail";
    }
}
