import axios from "axios";
const url = "http://localhost:8080/memes";

class XmemeService {
  async getMemes() {
    let result = {
      data: [],
      message: "",
      type: "",
    };
    await axios.get(url).then((response) => {
      result.data = response.data;
      if (response.status === 200) {
        result.message = "Meme Recieved";
        result.type = "Success";
      }
    });
    return result;
  }

  async submitMemes(memes) {
    let result = {
      data: [],
      message: "",
      type: "",
    };
    await axios.post(url, memes).then((response) => {
      result.message = "Meme Recieved";
      result.type = "Success";
    });
  }

  async UpdateMemes(memes,id) {
    let result = {
      data: [],
      message: "",
      type: "",
    };
    await axios.patch(url+ id, memes).then((response) => {
      result.message = "Meme Recieved";
      result.type = "Success";
    });
  }
}

export default new XmemeService();

