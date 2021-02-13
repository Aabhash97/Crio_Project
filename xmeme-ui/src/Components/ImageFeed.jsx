import Avatar from "@material-ui/core/Avatar";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardHeader from "@material-ui/core/CardHeader";
import CardMedia from "@material-ui/core/CardMedia";
import { red } from "@material-ui/core/colors";
import IconButton from "@material-ui/core/IconButton";
import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import React, { useLayoutEffect, useEffect, useState } from "react";
import logo from "../meme2.svg";
import ReactingComponent from "./emoji";
import XmemeService from "../service/XmemeService";
import { Grid } from "@material-ui/core";
import UpdateComponent from "./UpdateComponent";
import Button from "react-bootstrap/Button";
import UpdateIcon from "@material-ui/icons/Update";
import { useHistory } from "react-router-dom";
import MoreVertIcon from "@material-ui/icons/MoreVert";
import Update from "@material-ui/icons/Update";
import { useToasts } from "react-toast-notifications";

const useStyles = makeStyles((theme) => ({
  root: {
    maxWidth: 250,
  },
  media: {
    height: 0,
    paddingTop: "60%", // 16:9
  },
  avatar: {
    backgroundColor: red[500],
    width: theme.spacing(3),
    height: theme.spacing(3),
  },
}));

export default function ImageFeed() {
  const { addToast } = useToasts();

  const data = {
    i: [1],
  };
  const classes = useStyles();

  const [memes, setmemes] = useState([]);

  useLayoutEffect(() => {
    getMemes();
  }, [memes]);

  const getMemes = () => {
    XmemeService.getMemes().then((response) => {
      if (response.type === "Success") 
      setmemes(response.data);
      else {
        addToast(response.message, {
          appearance: "error",
          autoDismiss: true,
        });
      }
    });
  };
  return data.i.map((elem) => (
    <div style={{ padding: 20 }}>
      <Grid
        container
        spacing={2}
        direction="row"
        justify="flex-start"
        alignItems="flex-start"
      >
        {memes
          .slice(0)
          .reverse()
          .map((meme) => (
            <Grid item xs={3}>
              <Card className={classes.root}>
                <CardHeader
                  avatar={
                    <Avatar aria-label="Name" className={classes.avatar}>
                      {meme.name.charAt(0)}
                    </Avatar>
                  }
                  action={<UpdateComponent id={meme.id} />}
                  title={meme.name}
                />

                <CardMedia
                  className={classes.media}
                  image={meme.url}
                  title={meme.name + "'s Meme"}
                />
                <CardContent>
                  <Typography
                    variant="body2"
                    color="textSecondary"
                    component="p"
                  >
                    {meme.caption}
                  </Typography>
                </CardContent>
                <CardActions disableSpacing>
                  <ReactingComponent />
                </CardActions>
              </Card>
            </Grid>
          ))}
      </Grid>
    </div>
  ));
}
