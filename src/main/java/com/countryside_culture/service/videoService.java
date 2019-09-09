package com.countryside_culture.service;

import com.countryside_culture.entity.video;
import com.countryside_culture.entity.video_collect;
import com.countryside_culture.mapper.reviewMapper;
import com.countryside_culture.mapper.videoMapper;
import com.countryside_culture.mapper.video_collectMapper;
import com.countryside_culture.recommender.VideoRecommender;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class videoService {
    @Autowired
    videoMapper videomapper;
    @Autowired
    video_collectMapper video_collectmapper;
    @Autowired
    reviewMapper reviewmapper;
    @Autowired
    private VideoRecommender videoRecommender;

    public List<video> allhot() {
        return videomapper.allhot();
    }

    public List<video> hot(int kind, int amount) {
        return videomapper.hot(kind, amount);
    }

    public List<video> newest(int kind, int amount) {
        return videomapper.newest(kind, amount);
    }

    public List<video> tkind(int kind) {
        return videomapper.tkind(kind);
    }

    public List<video> pkind(int kind) {
        return videomapper.pkind(kind);
    }

    public List<video> selectall() {
        return videomapper.selectall();
    }

    public video selectone(int id) {
        return videomapper.selectone(id);
    }

    public int update(video video) {
        return videomapper.update(video);
    }


    public video_collect select(int uid, int id) {
        return video_collectmapper.select(uid, id);
    }

    public List<video_collect> showcollect(int uid) {
        return video_collectmapper.showcollect(uid);
    }

    public int updatecollect(video_collect video_collect) {
        return video_collectmapper.updatecollect(video_collect);
    }

    public int collect(video_collect video_collect) {
        return video_collectmapper.collect(video_collect);
    }

    // 推荐算法涉及
    public List<video> queryLookedProductsByUser(int userID) {
        return videomapper.queryProductsBySql(userID);
    }

    public List<video> recommendProductsBasedUser(int userID, int size) {
        List<Long> recommendedItems = null;
        try {
            recommendedItems = videoRecommender.userBasedRecommender(new Integer(userID).longValue(), size);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        return videomapper.queryProductsByIds(recommendedItems);
    }

    public List<video> recommendProductsBasedItem(int userID, int size) {
        List<Long> recommendedItems = null;
        try {
            recommendedItems = videoRecommender.itemBasedRecommender(new Integer(userID).longValue(), size);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        return videomapper.queryProductsByIds(recommendedItems);
    }
}
