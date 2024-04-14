package com.forum.service;

import com.forum.dtos.PostResDto;
import com.forum.dtos.PostSearchResDto;
import com.forum.model.Post;
import jakarta.persistence.EntityManager;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
    private EntityManager entityManager;

    public void createIndex() throws InterruptedException {
        SearchSession searchSession = Search.session(entityManager);
        MassIndexer massIndexer = searchSession.massIndexer(Post.class).threadsToLoadObjects(7);
        massIndexer.startAndWait();
    }

    @Override
    public List<PostSearchResDto> getAllPosts(String searchQuery) {
        SearchSession searchSession = Search.session(entityManager);
        SearchResult<Post> searchResult = searchSession.search(Post.class)
                .where(f -> f.match()
                        .fields("text")
                        .matching(searchQuery))
                .fetch(20);
        long hitResults = searchResult.total().hitCount();
        List<Post> postList = searchResult.hits();
        List<PostSearchResDto> postSearchResDtoArrayList = new ArrayList<>();
        for(Post post : postList){
            PostSearchResDto postSearchResDto = new PostSearchResDto();
            postSearchResDto.setPostId(post.getId());
            postSearchResDto.setText(post.getText());
            postSearchResDtoArrayList.add(postSearchResDto);
        }
        return postSearchResDtoArrayList;
    }
}
