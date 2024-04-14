import React, {Component} from "react";
import axios from "axios";

const BASE_URL = "http://localhost:8080/";

class Post extends Component{
    constructor(props){
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }
    async handleClick(evt){
        const getParticularPostUrl = `${BASE_URL}post/${this.props.data.postId}`
        console.log(getParticularPostUrl)
        let postData = await axios.get(getParticularPostUrl,{
            headers: {
                Accept: "application/json"
            }
        })
        console.log(postData.data);
    }
    render(){
        return(
            <div>
                <h1 onClick={this.handleClick}>{this.props.data.text}</h1>
            </div>
        )
    }
}

export default Post;