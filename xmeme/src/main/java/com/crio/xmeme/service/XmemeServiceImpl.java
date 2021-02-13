package com.crio.xmeme.service;

import com.crio.xmeme.model.Xmeme;
import com.crio.xmeme.repository.XmemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is Xmeme Service Class for Xmeme Application
 * Extended From XmemeService Interface to Perform Database Operations
 */
@Service
public class XmemeServiceImpl implements XmemeService {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XmemeRepository xmemeRepository;

    /**
     * This is createMeme Class for adding meme into the Database
     *
     * @param xmeme xmeme Object contains Payload for saving memes
     * @return meme ID
     */
    @Override
    public int createMeme(Xmeme xmeme) {
        xmemeRepository.save(xmeme);
        return xmeme.getId();
    }

    /**
     * This is createMeme Class for getting latest 100 memes from Database
     *
     * @return memes List
     */
    @Override
    public List<Xmeme> getMeme() {
        LOG.debug("Getting the memes");
        Page<Xmeme> memes = xmemeRepository.findAll(PageRequest.of(0, 100, Sort.by(Sort.Direction.DESC, "id")));
        ;
        return memes.getContent();
    }

    /**
     * This is getMemeById Class for getting llatest 100 memes from Database
     *
     * @param id Id for finding Meme mapped to it
     * @return Xmeme Object
     */
    @Override
    public Optional<Xmeme> getMemeById(int id) {
        LOG.debug("Getting Meme by Id");
        return xmemeRepository.findById(id);
    }

    /**
     * This is updateMeme Class for getting llatest 100 memes from Database
     *
     * @param meme Xmeme Object to update meme
     */
    @Override
    public void updateMeme(Optional<Xmeme> meme) {
        LOG.debug("Updating the Memes");
        xmemeRepository.save(meme.get());
    }

    /**
     * This is memeExist Function for checking if meme is present in Database
     *
     * @param meme Xmeme Object to search meme
     * @return List of found memes
     */
    @Override
    public List<Xmeme> memeExist(Xmeme meme) {
        LOG.debug("Checking Meme Exist Or Not");
        Xmeme meme2 = new Xmeme();
        meme2.setName(meme.getName());
        meme2.setUrl(meme.getUrl());
        meme2.setCaption(meme.getCaption());
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");
        Example<Xmeme> memeExample = Example.of(meme2, exampleMatcher);
        LOG.debug("Got the Meme");
        return xmemeRepository.findAll(memeExample);


    }


}
