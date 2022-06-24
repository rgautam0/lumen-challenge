package com.ctl.lumenchallenge.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ctl.lumenchallenge.model.User;
import com.ctl.lumenchallenge.model.UserV;
import com.ctl.lumenchallenge.service.LumenChallengeService;

@Service
public class LumenChallengeServiceImpl implements LumenChallengeService {

    // base URL
    @Value("${github.base.url}")
    private String BASE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserV getfollowers(String id, int count) {
        // fetch 1 level deep followers
        List<UserV> deep1Followers = getUserVFollowers(id, count);
        UserV user = covert(getUser(id));
        user.setFollowers(deep1Followers);

        user.getFollowers().forEach(d1User -> {
            // fetch 2 level deep followers
            List<UserV> deep2Followers = getUserVFollowers(d1User.getLogin(), count);
            d1User.setFollowers(deep2Followers);

            d1User.getFollowers().forEach(d2User -> {
                // fetch 3 level deep followers
                List<UserV> deep3Followers = getUserVFollowers(d2User.getLogin(), count);
                d2User.setFollowers(deep3Followers);
            });
        });
        return user;
    }

    /**
     * Get followers
     *
     * @param id
     * @param count
     * @return followers
     */
    private List<UserV> getUserVFollowers(String id, int count) {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(
                BASE_URL + id + "/following",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> users = responseEntity.getBody().stream().limit(count).collect(Collectors.toList());
        List<UserV> followers = new ArrayList<UserV>();
        for (User user : users) {
            UserV v = covert(user);
            followers.add(v);
        }
        return followers;
    }

    /**
     * Get user
     *
     * @param id
     * @return user
     */
    private User getUser(String id) {
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                BASE_URL + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                });
        return responseEntity.getBody();
    }

    /**
     * Wrapper User View object
     *
     * @param user
     * @return userV
     */
    private UserV covert(User user) {
        UserV userV = new UserV();
        userV.setLogin(user.getLogin());
        userV.setId(user.getId());
        userV.setNode_id(user.getNode_id());
        userV.setAvatar_url(user.getAvatar_url());
        userV.setGravatar_id(user.getGravatar_id());
        userV.setUrl(user.getUrl());
        userV.setHtml_url(user.getHtml_url());
        userV.setFollowers_url(user.getFollowers_url());
        userV.setFollowing_url(user.getFollowing_url());
        userV.setGists_url(user.getGists_url());
        userV.setStarred_url(user.getStarred_url());
        userV.setSubscriptions_url(user.getSubscriptions_url());
        userV.setOrganizations_url(user.getOrganizations_url());
        userV.setRepos_url(user.getRepos_url());
        userV.setEvents_url(user.getEvents_url());
        userV.setReceived_events_url(user.getReceived_events_url());
        userV.setType(user.getType());
        userV.setSite_admin(user.isSite_admin());
        return userV;
    }

}
