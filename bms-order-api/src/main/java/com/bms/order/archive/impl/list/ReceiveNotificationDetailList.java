package com.bms.order.archive.impl.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.ReceiveNotificationDetailEntity;
import com.bms.order.bean.entity.ReceiveNotificationDetailHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.ReceiveNotificationDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 收货通知单明细列表辅助类

 * @author li_huiqian

 */
public class ReceiveNotificationDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(ReceiveNotificationDetailList.class);

    private static final String TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION_DETAIL";

    private static final String HISTORY_TABLE_NAME = "ORDR_RECEIVE_NOTIFICATION_DETAIL_HISTORY";

    /** 收货通知单明细Entity */
    private List<ReceiveNotificationDetailEntity> entities;


    /** 收货通知单明细列表辅助类 */
    private List<ReceiveNotificationDetail> archives;

    public List<ReceiveNotificationDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 配送通知单明细表 */
    private List<DistributionNotificationDetail> distributionNotificationDetails;

    /** 收货通知单 */
    private List<ReceiveNotification> receiveNotifications;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(Long[] ids) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(List<ReceiveNotificationDetailEntity> entities) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(ReceiveNotificationDetail[] archives) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notEmpty(archives);
        for (ReceiveNotificationDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (ReceiveNotificationDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getDistributionNotificationDetailId());
        this.distributionNotificationDetails = new ArrayList<>();
        this.distributionNotificationDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(DistributionNotificationDetail[] linkedArchives) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notEmpty(linkedArchives);
        this.distributionNotificationDetails = new ArrayList<>();
        for (DistributionNotificationDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getDistributionNotificationDetailId());
            this.distributionNotificationDetails.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(ReceiveNotification linkedArchive) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReceiveNotificationId());
        this.receiveNotifications = new ArrayList<>();
        this.receiveNotifications.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  ReceiveNotificationDetailList(ReceiveNotification[] linkedArchives) {
        logger.info(this + "#ReceiveNotificationDetailList");
        Assert.notEmpty(linkedArchives);
        this.receiveNotifications = new ArrayList<>();
        for (ReceiveNotification linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getReceiveNotificationId());
            this.receiveNotifications.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.distributionNotificationDetailId");
        
        } else if (target instanceof ReceiveNotification) {
            LinkHelper.link(this.archives, target, "entity.receiveNotificationId");
        
        } else if (target instanceof BuyerReturnDetail) {
            LinkHelper.link(this.archives, target, "entity.receiveNotificationDetailId");
        
        }
    }
    @Override
    public void link(List<?> targets) {
        logger.info(this + "#link");
        if (targets == null || targets.size() == 0)
            return;

        Object obj0 = targets.get(0);
        if (!(obj0 instanceof Linkable))
            return;
        Linkable item0 = (Linkable) obj0;

        if (item0 instanceof DistributionNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.distributionNotificationDetailId");
        
        } else if (item0 instanceof ReceiveNotification) {
            LinkHelper.link(this.archives, targets, "entity.receiveNotificationId");
        
        } else if (item0 instanceof BuyerReturnDetail) {
            LinkHelper.link(this.archives, targets, "entity.receiveNotificationDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (distributionNotificationDetails != null && distributionNotificationDetails.size() != 0)
            map.put("distributionNotificationDetails", distributionNotificationDetails);
        else if (receiveNotifications != null && receiveNotifications.size() != 0)
            map.put("receiveNotifications", receiveNotifications);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);
        List<ReceiveNotificationDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (ReceiveNotificationDetailEntity entity : entities) {
            ReceiveNotificationDetail archive = ReceiveNotificationDetail.build(getBlackboard()).forCreate(entity);
            archive.setDataSynced(true);
            archive.setHistory();

            if (archives == null)
                archives = new ArrayList<>();
            archives.add(archive);
        }

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);

        // 获取Dao
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationDetailEntity entity = entities.get(i);
            entity.setReceiveNotificationDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationDetailEntity entity = entities.get(i);
            insertCommon(entity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    /**
     * 为以此时的entity建立历史Entity，此时的数据必须从数据库查出来，这一步不插入数据库
     *
     */
    public void setHistory() {
        logger.info(this + "#setHistory");
        Assert.notEmpty(archives, "must create or complete first");
        for (ReceiveNotificationDetail archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationDetailEntity entity = entities.get(i);
            updateCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notEmpty(entities);

        // 获取Dao
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            ReceiveNotificationDetailEntity entity = entities.get(i);
            deleteCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    /**
     * 保存历史数据，在修改或删除之后调用
     *
     */
    private void saveHistory() {
        logger.info(this + "#saveHistory");
        Assert.notEmpty(archives, "must modify or delete first");
        // 获取历史Entity
        List<ReceiveNotificationDetailHistoryEntity> historyEntities = new ArrayList<>();
        for (ReceiveNotificationDetail archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
        }
        // 获取Dao
        ReceiveNotificationDetailDao dao = getDao(ReceiveNotificationDetailDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (ReceiveNotificationDetail archive : archives) {
            archive.getHistoryEntity().setHistoryId(historyId);
            historyId ++;
        }

        // 插入数据库
        int count = dao.batchSaveHistory(historyEntities);
        if (count != archives.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (ReceiveNotificationDetail archive : archives)
                archive.setDataSynced(dataSynced);
        super.setDataSynced(dataSynced);
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder{

    private Blackboard blackboard;

    public  Builder(Blackboard blackboard) {
        logger.info(this + "#Builder");
        this.blackboard = blackboard;
    }

    /**
     * 创建对象列表，用于根据id查询数据，此对象列表必须使用complete方法补全
     *
     */
    public ReceiveNotificationDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetailList build = new ReceiveNotificationDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public ReceiveNotificationDetailList forCreate(ReceiveNotificationDetail[] archives) {
        logger.info(this + "#forCreate");
        ReceiveNotificationDetailList build = new ReceiveNotificationDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public ReceiveNotificationDetailList forUpdate(ReceiveNotificationDetail[] archives) {
        logger.info(this + "#forUpdate");
        ReceiveNotificationDetailList build = new ReceiveNotificationDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.distributionNotificationDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public ReceiveNotificationDetailList forComplete(DistributionNotificationDetail linkedArchive) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetailList build = new ReceiveNotificationDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.receiveNotificationId查询数据，此对象必须使用complete方法补全
     *
     */
    public ReceiveNotificationDetailList forComplete(ReceiveNotification linkedArchive) {
        logger.info(this + "#forComplete");
        ReceiveNotificationDetailList build = new ReceiveNotificationDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}