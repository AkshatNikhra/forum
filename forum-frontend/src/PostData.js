import React, {Component} from "react";
import Comment from "./Comment";

class PostData extends Component{
    constructor(props){
        super(props);
    }
    render(){
        console.log("checking")
        console.log(this.props.data);
        let comments = this.props.data.commentResDtoList.map(p => {
            return <Comment key={p.commentId} data={p}/>
        })
        return(
            <div>
                <h1>{this.props.data.text}</h1>
                <p>User: {this.props.data.userResDto.name}</p>
                {comments}
            </div>
        )
    }
}

export default PostData;