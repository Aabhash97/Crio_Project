package com.crio.xmeme.service;

import com.crio.xmeme.model.Xmeme;

import java.util.List;
import java.util.Optional;

/**
 * This is Xmeme Service Interface for Xmeme Application
 * Extended By XmemeServiceImpl to Perform Database Operations
 */
public interface XmemeService {

    int createMeme(Xmeme xmeme);

    List<Xmeme> getMeme();

    Optional<Xmeme> getMemeById(int id);

    void updateMeme(Optional<Xmeme> meme);

    List<Xmeme> memeExist(Xmeme meme);
}
