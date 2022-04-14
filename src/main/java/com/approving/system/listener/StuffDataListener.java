package com.approving.system.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.approving.system.domain.Stuff;
import com.approving.system.service.StuffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StuffDataListener extends AnalysisEventListener<Stuff> {

    private StuffService stuffService;
    public StuffDataListener(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */

    private static final int BATCH_COUNT = 5;
    List<Stuff> list = new ArrayList<Stuff>();

    @Override
    public void invoke(Stuff data, AnalysisContext context) {
        //log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        //log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        //log.info("{}条数据，开始存储数据库！", list.size());
        if (!CollectionUtils.isEmpty(list)) {
            stuffService.saveAllStuffs(list);
        }
        //log.info("存储数据库成功！");
    }
}
