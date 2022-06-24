package com.ctl.lumenchallenge.service;

import com.ctl.lumenchallenge.model.UserV;

public interface LumenChallengeService {

    UserV getfollowers(String id, int count);
}
