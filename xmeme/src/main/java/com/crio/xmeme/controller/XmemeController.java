package com.crio.xmeme.controller;

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


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class XmemeController {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XmemeService xmemeService;

    @RequestMapping(value = "memes", method = RequestMethod.POST)
    public ResponseEntity<Object> createMeme(@RequestBody Xmeme xmeme) {
        int id = xmemeService.createMeme(xmeme);
        MemeId memeId = new MemeId();
        memeId.setId(id);
        LOG.debug("Added :" + xmeme);
        return new ResponseEntity<>(memeId, HttpStatus.CREATED);
    }

    @GetMapping("/memes")
    public ResponseEntity<Object> getAllMemes() {
        LOG.debug("Getting all the Memes");
        List<Xmeme> xmemeList;
        xmemeList = xmemeService.getMeme();
        LOG.debug("Found " + xmemeList.size() + "memes");
        return new ResponseEntity<>(xmemeList, HttpStatus.OK);
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<Object> getMemeById(@PathVariable int id) {
        LOG.debug("Getting all the Memes");
        Optional<Xmeme> xmeme;
        xmeme = xmemeService.getMemeById(id);
        if (xmeme.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        LOG.debug("Found the meme");
        return new ResponseEntity<>(xmeme, HttpStatus.OK);
    }

    @PatchMapping("memes/{id}")
    public ResponseEntity<Object> patchMemeById(@PathVariable int id, @RequestBody Xmeme xmeme) {
        LOG.debug("Updating Memes");
        Optional<Xmeme> meme = xmemeService.getMemeById(id);
        if (meme.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        LOG.debug("Found the meme");
        meme.get().setUrl(xmeme.getUrl());
        meme.get().setCaption(xmeme.getCaption());
        xmemeService.updateMeme(meme);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
