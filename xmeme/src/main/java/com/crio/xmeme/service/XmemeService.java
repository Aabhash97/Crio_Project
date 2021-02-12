package com.crio.xmeme.service;

import com.crio.xmeme.model.Xmeme;

import java.util.List;
import java.util.Optional;

public interface XmemeService {
    int createMeme(Xmeme xmeme);

    List<Xmeme> getMeme();

    Optional<Xmeme> getMemeById(int id);

    void updateMeme(Optional<Xmeme> meme);
}
