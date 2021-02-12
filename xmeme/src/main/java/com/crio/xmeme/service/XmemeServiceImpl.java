package com.crio.xmeme.service;

import com.crio.xmeme.model.Xmeme;
import com.crio.xmeme.repository.XmemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XmemeServiceImpl implements XmemeService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XmemeRepository xmemeRepository;

    @Override
    public int createMeme(Xmeme xmeme) {
        xmemeRepository.save(xmeme);
        return xmeme.getId();
    }

    @Override
    public List<Xmeme> getMeme() {
        log.debug("Getting the memes");
        return xmemeRepository.findAll();
    }

    @Override
    public Optional<Xmeme> getMemeById(int id) {
        log.debug("Getting Meme by Id");
        return xmemeRepository.findById(id);
    }

    @Override
    public void updateMeme(Optional<Xmeme> meme) {
        xmemeRepository.save(meme.get());
    }

}
