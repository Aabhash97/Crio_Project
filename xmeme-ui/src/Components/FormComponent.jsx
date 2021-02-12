import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import TextField from "@material-ui/core/TextField";
import React from "react";
import XmemeService from "../service/XmemeService";
import { useState } from "react";
import "react-awesome-button/dist/styles.css";
import { AwesomeButton } from "react-awesome-button";
import styles from "../theme-blue.css";
import * as yup from "yup";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import Form from "react-bootstrap/Form";
import { Button } from "@material-ui/core";

const schema = yup.object().shape({
  name: yup.string().required(),
  caption: yup.string().required(),
  // url: yup
  //   .string()
  //   .matches(
  //     /((https?):\/\/)?(www.)?[a-z0-9]+(\.[a-z]{2,}){1,3}(#?\/?[a-zA-Z0-9#]+)*\/?(\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$/,
  //     "Enter correct url!"
  //   )
  //   .required(),
  
});

export default function FormComponent() {
  const initialState = {
    name: "",
    caption: "",
    url: "",
    id:"",
  };

  const { register, handleSubmit, errors } = useForm({
    resolver: yupResolver(schema),
  });
  const [meme, setMeme] = useState(initialState);
  const saveMemes = () => {
    console.log("Im here");
    var data = {
      name: meme.name,
      url: meme.url,
      caption: meme.caption,
      id:meme.id,
    };
    setOpen(false);
    XmemeService.submitMemes(data);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setMeme({ ...meme, [name]: value });
  };
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <AwesomeButton type="primary" ripple onPress={handleClickOpen}>
        Submit 🚀
      </AwesomeButton>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <form>
          <DialogTitle id="form-dialog-title">Hey👋</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Start your Meme Making Journey😀Publish Your meme Now😍
            </DialogContentText>
            <TextField
              autoFocus
              name="name"
              required
              value={meme.name}
              margin="dense"
              id="name"
              label="Name"
              type="name"
              fullWidth
              onChange={handleInputChange}
              ref={register}
            />


            <br></br>

            <TextField
              name="caption"
              required
              value={meme.caption}
              margin="dense"
              id="caption"
              label="Caption"
              type="caption"
              fullWidth
              onChange={handleInputChange}
              ref={register}
            />

            <TextField
              name="url"
              required
              value={meme.url}
              margin="dense"
              id="url"
              label="Url"
              type="url"
              fullWidth
              onChange={handleInputChange}
              ref={register}
            />
            
          </DialogContent>
          <DialogActions>
            <AwesomeButton size="small" type="secondary" onPress={handleClose}>
              Cancel
            </AwesomeButton>
            <AwesomeButton
              size="small"
              type="primary"
              onPress={saveMemes}
            >
              Submit
            </AwesomeButton>
          </DialogActions>
        </form>
      </Dialog>
    </div>
  );
}
