package com.crio.xmeme.controller;

import com.crio.xmeme.exception.XmemeNotFoundException;
import com.crio.xmeme.model.MemeId;
import com.crio.xmeme.model.Xmeme;
import com.crio.xmeme.service.XmemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The XmemeController class is for Exposing
 * Endpoints for REST API
 */
@RestController
@CrossOrigin("*")
public class XmemeController {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XmemeService xmemeService;

    /**
     * This is POST Request for Xmeme Application
     *
     * @param xmeme xmeme Object contains Payload for saving memes
     * @return list of All Memes
     */
    @RequestMapping(value = "memes", method = RequestMethod.POST)
    public ResponseEntity<Object> createMeme(@RequestBody Xmeme xmeme) {
        if (!xmemeService.memeExist(xmeme).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int id = xmemeService.createMeme(xmeme);

        MemeId memeId = new MemeId();


        memeId.setId(id);
        LOG.debug("Added :" + xmeme);
        return new ResponseEntity<>(memeId, HttpStatus.CREATED);

    }

    /**
     * This is GET Request for Xmeme Application
     *
     * @param
     * @return list of All Memes
     */
    @GetMapping("/memes")
    public ResponseEntity<Object> getAllMemes() {
        LOG.debug("Getting all the Memes");
        List<Xmeme> xmemeList;
        xmemeList = xmemeService.getMeme();
        LOG.debug("Found memes");
        return new ResponseEntity<>(xmemeList, HttpStatus.OK);
    }

    /**
     * This is GET Request for Xmeme Application
     *
     * @param id Parameter to fetch meme by  meme Id
     * @return list of All Memes
     */
    @GetMapping("/memes/{id}")
    public ResponseEntity<Object> getMemeById(@PathVariable int id) {
        LOG.debug("Getting all the Memes");
        Optional<Xmeme> xmeme;
        xmeme = xmemeService.getMemeById(id);
        if (xmeme.isEmpty())
            throw new XmemeNotFoundException();
        LOG.debug("Found the meme with id" + id);
        return new ResponseEntity<>(xmeme, HttpStatus.OK);
    }

    /**
     * This is PATCH Request for Xmeme Application
     *
     * @param id,xmeme ID for fetching meme by Id and xmeme Object Contains Updated Contents
     * @return HTTP Response
     */
    @PatchMapping("memes/{id}")
    public ResponseEntity<Object> patchMemeById(@PathVariable int id, @RequestBody Xmeme xmeme) {
        LOG.debug("Updating Memes");
        Optional<Xmeme> meme = xmemeService.getMemeById(id);
        if (meme.isEmpty())
            throw new XmemeNotFoundException();
        if (!xmemeService.memeExist(xmeme).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        LOG.debug("Updating the meme" + xmeme);
        meme.get().setUrl(xmeme.getUrl());
        meme.get().setCaption(xmeme.getCaption());
        xmemeService.updateMeme(meme);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
