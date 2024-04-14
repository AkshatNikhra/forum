import React,{Component} from "react";

class Comment extends Component{
    render(){
        return(
            <div>
                <h3> {this.props.data.text}</h3>
                <p>user: {this.props.data.userResDto.name} </p>
            </div>
        )
    }
}

export default Comment;