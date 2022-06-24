package com.ctl.lumenchallenge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void create_new_user() {
        User user = new User();
        user.setLogin("maddox");
        user.setId(260);
        user.setNode_id("MDQ6VXNlcjI2MA==");
        user.setAvatar_url("https://avatars.githubusercontent.com/u/260?v=4");
        user.setUrl("https://api.github.com/users/maddox");
        user.setHtml_url("https://api.github.com/users/maddox");
        user.setFollowers_url("https://api.github.com/users/maddox/followers");
        user.setFollowing_url("https://api.github.com/users/maddox/following{/other_user}");
        user.setGists_url("https://api.github.com/users/maddox/gists{/gist_id}");
        user.setStarred_url("https://api.github.com/users/maddox/starred{/owner}{/repo}");
        user.setSubscriptions_url("https://api.github.com/users/maddox/subscriptions");
        user.setOrganizations_url( "https://api.github.com/users/maddox/orgs");
        user.setRepos_url("https://api.github.com/users/maddox/repos");
        user.setEvents_url("https://api.github.com/users/maddox/events{/privacy}");
        user.setReceived_events_url("https://api.github.com/users/maddox/received_events");
        user.setType("User");
        user.setSite_admin(false);

        assertNotNull(user);
        assertEquals("maddox", user.getLogin(), "Login is incorrect");
    }
}
